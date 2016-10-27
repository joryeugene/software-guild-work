package com.jorypestorious.vendingmachinemvc.controller;

import com.jorypestorious.vendingmachinemvc.dto.Money;
import com.jorypestorious.vendingmachinemvc.dao.VendingMachineDao;
import com.jorypestorious.vendingmachinemvc.dto.Item;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeControllerNoAjax {

    private final VendingMachineDao dao;
    private Money money = null;
    private boolean notEnoughMoney = false;

    @Inject
    public HomeControllerNoAjax(VendingMachineDao dao) {
        this.dao = dao;
        dao.addItem(new Item("Item1", 1.5, 15));
        dao.addItem(new Item("Item2", 2, 3));
    }

    @RequestMapping(value = "/displayVendingMachineNoAjax", method = RequestMethod.GET)
    public String displayVendingMachineNoAjax(Model model) {
        List<Item> itemList = dao.getAllItems();
        
        if (money == null) {
            money = new Money();
        }
        
        model.addAttribute("money", money);
        model.addAttribute("notEnoughMoney", notEnoughMoney);
        model.addAttribute("itemList", itemList);
        notEnoughMoney = false;
        
        return "displayVendingMachineNoAjax";
    }

    @RequestMapping(value = "displayNewItemFormNoAjax", method = RequestMethod.GET)
    public String displayNewContactFormNoAjax(Model model) {
        Item item = new Item();
        model.addAttribute("item", item);
        return "newItemFormNoAjax";
    }

    @RequestMapping(value = "/addNewItemNoAjax", method = RequestMethod.POST)
    public String addNewItemNoAjax(@Valid @ModelAttribute("item") Item item, BindingResult result) {
        if (result.hasErrors()) {
            return "newItemFormNoAjax";
        }
        
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
        Item item = dao.getItemById(id);
        
        if (item.getCount() > 0 && item.getCost() < money.getAmount()) {
            notEnoughMoney = false;
            dao.buyItem(id, money.getAmount());
            money.removeAmount(item.getCost());
            // add item and quantity to list of bought things TODO
        } else {
            notEnoughMoney = true;
        }
        
        return "redirect:displayVendingMachineNoAjax";
    }
    
    @RequestMapping(value = "/addMoneyNoAjax", method = RequestMethod.POST)
    public String addMoneyNoAjax(@Valid @ModelAttribute("money") Money newMoney, BindingResult result) {
        if (result.hasErrors()) {
            return "displayVendingMachineNoAjax";
        }
        
        money.addAmount(newMoney.getAmount());
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
    public String editItemNoAjax(@Valid @ModelAttribute("item") Item item, BindingResult result) {
        if (result.hasErrors()) {
            return "editItemFormNoAjax";
        }
        
        dao.updateItem(item);
        return "redirect:displayVendingMachineNoAjax";
    }
}
