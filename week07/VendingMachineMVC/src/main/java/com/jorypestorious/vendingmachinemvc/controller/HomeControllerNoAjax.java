package com.jorypestorious.vendingmachinemvc.controller;

import com.jorypestorious.vendingmachinemvc.dao.VendingMachineDao;
import com.jorypestorious.vendingmachinemvc.dto.Item;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeControllerNoAjax {

    private final VendingMachineDao dao;

    @Inject
    public HomeControllerNoAjax(VendingMachineDao dao) {
        this.dao = dao;
        dao.addItem(new Item("Item1", 1.5, 15));
        dao.addItem(new Item("Item2", 2, 3));
    }

    @RequestMapping(value = "/displayVendingMachineNoAjax", method = RequestMethod.GET)
    public String displayVendingMachineNoAjax(Model model) {
        List<Item> itemList = dao.getAllItems();
        model.addAttribute("itemList", itemList);
        return "displayVendingMachineNoAjax";
    }

    @RequestMapping(value = "displayNewItemFormNoAjax", method = RequestMethod.GET)
    public String displayNewContactFormNoAjax() {
        return "newItemFormNoAjax";
    }

    @RequestMapping(value = "/addNewItemNoAjax", method = RequestMethod.POST)
    public String addNewItemNoAjax(HttpServletRequest req) {
        String name = req.getParameter("name");
        double cost = Double.parseDouble(req.getParameter("cost"));
        int count = Integer.parseInt(req.getParameter("count"));

        Item item = new Item(name, cost, count);
        dao.addItem(item);
        return "redirect:displayVendingMachineNoAjax";
    }

    @RequestMapping(value = "/deleteItemNoAjax", method = RequestMethod.GET)
    public String deleteItemNoAjax(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("id"));
        dao.removeItem(id);
        return "redirect:displayVendingMachineNoAjax";
    }

    @RequestMapping(value = "/buyItemNoAjax", method = RequestMethod.GET)
    public String buyItemNoAjax(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("id"));
        dao.buyItem(id, 100); // introduce money
        return "redirect:displayVendingMachineNoAjax";
    }

    @RequestMapping(value = "/displayEditItemFormNoAjax", method = RequestMethod.GET)
    public String displayEditItemFormNoAjax(HttpServletRequest req, Model model) {
        int id = Integer.parseInt(req.getParameter("id"));
        Item item = dao.getItemById(id);
        model.addAttribute("item", item);
        return "editItemFormNoAjax";
    }

    @RequestMapping(value = "/editItemNoAjax", method = RequestMethod.POST)
    public String editItemNoAjax(@ModelAttribute("item") Item item) {
        dao.updateItem(item);

        return "redirect:displayVendingMachineNoAjax";
    }
}
