package com.jorypestorious.dvdlibrarymvc3.dao;

import com.jorypestorious.dvdlibrarymvc3.dto.DVD;
import com.jorypestorious.dvdlibrarymvc3.dto.MpaaDVDCount;
import com.jorypestorious.dvdlibrarymvc3.dto.YearDVDCount;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class DVDLibraryDaoDbImpl implements DVDLibraryDao {

    // #1 - All SQL code is in the form of Prepared Statements
    private static final String SQL_INSERT_DVD
            = "insert into Dvds (Title, Year, Mpaa, Director, Studio, Note, Overview, Image) values (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_DVD
            = "delete from Dvds where DvdID = ?";
    private static final String SQL_SELECT_DVD
            = "select * from Dvds where DvdID = ?";
    private static final String SQL_UPDATE_DVD
            = "update Dvds set Title = ?, Year = ?, Mpaa = ?, Director = ?, Studio = ?, Note = ?, Overview = ?, Image = ? where DvdID = ?";
    private static final String SQL_SELECT_ALL_DVDS
            = "select * from Dvds";
    private static final String SQL_SELECT_DVDS_WITH_MPAA
            = "SELECT * FROM Dvds WHERE Mpaa = ? AND Title LIKE ? AND Year LIKE ? AND Director LIKE ? AND Studio LIKE ?";
    private static final String SQL_SELECT_DVDS_NO_MPAA
            = "SELECT * FROM Dvds WHERE Title LIKE ? AND Year LIKE ? AND Director LIKE ? AND Studio LIKE ?";
    private static final String SQL_SELECT_MPAA_DVD_COUNTS
            = "SELECT Mpaa, count(*) as NumDvds FROM Dvds group by mpaa;";
    private static final String SQL_SELECT_YEAR_DVD_COUNTS
            = "SELECT Year, count(*) as NumDvds FROM Dvds group by year;";
    
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public DVD addDVD(DVD dvd) {
        jdbcTemplate.update(SQL_INSERT_DVD,
                dvd.getTitle(),
                dvd.getYear(),
                dvd.getMpaa(),
                dvd.getDirector(),
                dvd.getStudio(),
                dvd.getNote(),
                dvd.getOverview(),
                dvd.getImage());
        dvd.setId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class));
        return dvd;
    }

    @Override
    public void removeDVD(int id) {
        jdbcTemplate.update(SQL_DELETE_DVD, id);
    }

    @Override
    public void updateDVD(DVD dvd) {
        jdbcTemplate.update(SQL_UPDATE_DVD,
                dvd.getTitle(),
                dvd.getYear(),
                dvd.getMpaa(),
                dvd.getDirector(),
                dvd.getStudio(),
                dvd.getNote(),
                dvd.getOverview(),
                dvd.getImage(),
                dvd.getId());
    }

    @Override
    public List<DVD> getAllDVDs() {
        return jdbcTemplate.query(SQL_SELECT_ALL_DVDS, new DVDMapper());
    }

    @Override
    public DVD getDVDById(int id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_DVD,
                    new DVDMapper(), id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<DVD> searchDVDs(Map<SearchTerm, String> criteria) {
        String titleCriteria = "%" + criteria.get(SearchTerm.TITLE) + "%";
        String yearCriteria = "%" + criteria.get(SearchTerm.YEAR) + "%";
        String mpaaCriteria = criteria.get(SearchTerm.MPAA);
        String directorCriteria = "%" + criteria.get(SearchTerm.DIRECTOR) + "%";
        String studioCriteria = "%" + criteria.get(SearchTerm.STUDIO) + "%";

        if (mpaaCriteria.length() > 0) {
            return jdbcTemplate.query(SQL_SELECT_DVDS_WITH_MPAA,
                    new DVDMapper(),
                    mpaaCriteria,
                    titleCriteria,
                    yearCriteria,
                    directorCriteria,
                    studioCriteria);
        } else {
            return jdbcTemplate.query(SQL_SELECT_DVDS_NO_MPAA,
                    new DVDMapper(),
                    titleCriteria,
                    yearCriteria,
                    directorCriteria,
                    studioCriteria);
        }
    }

    @Override
    public List<MpaaDVDCount> getMpaaDVDCounts() {
        return jdbcTemplate.query(SQL_SELECT_MPAA_DVD_COUNTS,
                new MpaaDVDCountMapper());
    }
    @Override
    public List<YearDVDCount> getYearDVDCounts() {
        return jdbcTemplate.query(SQL_SELECT_YEAR_DVD_COUNTS,
                new YearDVDCountMapper());
    }

    private static final class DVDMapper implements RowMapper<DVD> {

        public DVD mapRow(ResultSet rs, int rowNum) throws SQLException {
            DVD dvd = new DVD();
            dvd.setId(rs.getInt("DvdID"));
            dvd.setTitle(rs.getString("Title"));
            dvd.setYear(rs.getString("Year"));
            dvd.setMpaa(rs.getString("Mpaa"));
            dvd.setDirector(rs.getString("Director"));
            dvd.setStudio(rs.getString("Studio"));
            dvd.setNote(rs.getString("Note"));
            dvd.setOverview(rs.getString("Overview"));
            dvd.setImage(rs.getString("Image"));
            return dvd;
        }
    }

    private static final class MpaaDVDCountMapper implements ParameterizedRowMapper<MpaaDVDCount> {
        @Override 
        public MpaaDVDCount mapRow(ResultSet rs, int i) throws SQLException {
            MpaaDVDCount count = new MpaaDVDCount();
            count.setMpaa(rs.getString("Mpaa"));
            count.setNumDVDs(rs.getInt("NumDvds"));
            return count;
        }
    }
    
    private static final class YearDVDCountMapper implements ParameterizedRowMapper<YearDVDCount> {
        @Override 
        public YearDVDCount mapRow(ResultSet rs, int i) throws SQLException {
            YearDVDCount count = new YearDVDCount();
            count.setYear(rs.getString("Year"));
            count.setNumDVDs(rs.getInt("NumDvds"));
            return count;
        }
    }
}