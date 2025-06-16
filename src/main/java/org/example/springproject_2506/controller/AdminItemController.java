package org.example.springproject_2506.controller;

import lombok.RequiredArgsConstructor;
import org.example.springproject_2506.entity.DisplayStatus;
import org.example.springproject_2506.entity.Item;
import org.example.springproject_2506.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/items")
@RequiredArgsConstructor
public class AdminItemController {

    private final ItemService itemService;

    // 상품 목록 조회 (관리자용)
    @GetMapping
    public String listItems(Model model) {
        List<Item> items = itemService.getAllItems();
        model.addAttribute("items", items);
        return "admin/item-list"; // 템플릿 이름 (admin/item-list.html 만들어야 함)
    }

    // 등록 폼 페이지
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("item", new Item());
        model.addAttribute("statuses", DisplayStatus.values());
        return "admin/item-form";
    }

    // 등록 처리
    @PostMapping
    public String createItem(@ModelAttribute Item item) {
        itemService.saveItem(item);
        return "redirect:/admin/items";
    }

    // 수정 폼 페이지
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);
        model.addAttribute("statuses", DisplayStatus.values());
        return "admin/item-form";
    }

    // 수정 처리
    @PostMapping("/{id}")
    public String updateItem(@PathVariable Long id, @ModelAttribute Item item) {
        itemService.updateItem(id, item);
        return "redirect:/admin/items";
    }
}

