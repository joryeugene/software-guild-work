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
    }
    
    private void populateVendingMachine() {
        dao.addItem(new Item("Twinkie", .5, 2));
        dao.addItem(new Item("Wrigley's Winterfresh Gum", 1.25, 3));
        dao.addItem(new Item("Hot Tamales", 1.75, 7));
        dao.addItem(new Item("Sour Patch Kids", 1.25, 9));
        dao.addItem(new Item("Rockstar Energy Drink", 2.25, 5));
        dao.addItem(new Item("Old Man Pretzels", 1.25, 5));
        dao.addItem(new Item("Sun Chips", 1.50, 7));
    }
    
    @RequestMapping(value = "/displayVendingMachineNoAjax", method = RequestMethod.GET)
    public String displayVendingMachineNoAjax(Model model) {
        if (money == null) {
            money = new Money();
            populateVendingMachine();
        }
        
        List<Item> itemList = dao.getAllItems();
        
        Item item = new Item();
        model.addAttribute("item", item);
        model.addAttribute("money", money);
        model.addAttribute("itemList", itemList);
        model.addAttribute("notEnoughMoney", notEnoughMoney);
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
    public String addNewItemNoAjax(@Valid @ModelAttribute("item") Item item, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("money", money);
            model.addAttribute("itemList", dao.getAllItems());
            return "displayVendingMachineNoAjax";
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
        
        if (item.getCount() > 0 && item.getCost() <= money.getAmount()) {
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
    public String addMoneyNoAjax(HttpServletRequest req) {
        money.addAmount(Double.parseDouble(req.getParameter("amount")));
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
