package com.jorypestorious.dvdlibrarymvc.dao;

import com.jorypestorious.dvdlibrarymvc.dto.DVD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
    private static final String SQL_SELECT_DVDS_BY_TITLE
            = "select * from Dvds where Title = ?";
    private static final String SQL_SELECT_DVDS_BY_MPAA
            = "select * from Dvds where Mpaa = ?";

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

    public List<DVD> searchDVDsByTitle(String title) {
        return jdbcTemplate.query(SQL_SELECT_DVDS_BY_TITLE, new DVDMapper());
    }

    public List<DVD> searchDVDsByMpaa(String mpaa) {
        return jdbcTemplate.query(SQL_SELECT_DVDS_BY_MPAA, new DVDMapper());
    }

    @Override
    public List<DVD> searchDVDs(Map<SearchTerm, String> criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

}
