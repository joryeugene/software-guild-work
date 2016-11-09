package com.jorypestorious.dvdlibrarymvc.controller;

import com.google.visualization.datasource.datatable.ColumnDescription;
import com.google.visualization.datasource.datatable.DataTable;
import com.google.visualization.datasource.datatable.value.ValueType;
import com.google.visualization.datasource.datatable.TableRow;
import com.google.visualization.datasource.render.JsonRenderer;
import com.jorypestorious.dvdlibrarymvc.dao.DVDLibraryDao;
import com.jorypestorious.dvdlibrarymvc.dto.MpaaDVDCount;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StatsController {

    private final DVDLibraryDao dao;

    @Inject
    public StatsController(DVDLibraryDao dao) {
        this.dao = dao;;
    }

    @RequestMapping(value = "/stats", method = RequestMethod.GET)
    public String displayStatsPage() {
        return "stats";
    }

    @RequestMapping(value = "/stats/mpaachart", method = RequestMethod.GET)
    @ResponseBody
    public String getMpaaChart() {
        try {
            List<MpaaDVDCount> counts = dao.getMpaaDVDCounts();

            DataTable t = new DataTable();
            t.addColumn(new ColumnDescription("MpaaRating",
                    ValueType.TEXT,
                    "MPAA Rating"));
            t.addColumn(new ColumnDescription("NumberDvds",
                    ValueType.NUMBER,
                    "# DVDs"));

            for (MpaaDVDCount currentCount : counts) {
                TableRow tr = new TableRow();
                tr.addCell(currentCount.getMpaa());
                tr.addCell(currentCount.getNumDVDs());
                t.addRow(tr);
            }

            return JsonRenderer.renderDataTable(t, true, false, false).toString();
        } catch (Exception e) {
            return "Invalid Data";
        }
    }
}
