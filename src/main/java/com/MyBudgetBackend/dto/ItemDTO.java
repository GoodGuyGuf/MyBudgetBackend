package com.MyBudgetBackend.dto;

import com.MyBudgetBackend.entity.Item;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ItemDTO {
    private Integer id;
    private String name;
    private int cost;
    private Date date;
    private ExpenseDTO expenseDTO;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ExpenseDTO getExpenseDTO() {
        return expenseDTO;
    }

    public void setExpenseDTO(ExpenseDTO expenseDTO) {
        this.expenseDTO = expenseDTO;
    }

    public static Item convertToItem(ItemDTO itemDTO) {
        Item item = new Item();
        item.setId(itemDTO.getId());
        item.setName(itemDTO.getName());
        item.setCost(itemDTO.getCost());
        item.setDate(itemDTO.getDate());
        item.setExpense(ExpenseDTO.convertToExpense(itemDTO.getExpenseDTO()));
        return item;
    }

    public static List<Item> convertItemDTOsToItems(List<ItemDTO> itemDTOs) {
        List<Item> items = new ArrayList<>();
        itemDTOs.forEach(ItemDTO -> {
            items.add(ItemDTO.convertToItem(ItemDTO));
        });
        return items;
    }
}