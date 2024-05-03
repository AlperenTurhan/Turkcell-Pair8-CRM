package com.turkcell.pair8.customerservice.controllers;

import com.pair4.paging.PageInfo;
import com.turkcell.pair8.customerservice.services.abstracts.AccountService;
import com.turkcell.pair8.customerservice.services.dtos.account.request.AddAccountRequest;
import com.turkcell.pair8.customerservice.services.dtos.account.request.UpdateAccountRequest;
import com.turkcell.pair8.customerservice.services.dtos.account.response.AddAccountResponse;
import com.turkcell.pair8.customerservice.services.dtos.account.response.GetAllAccountResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public AddAccountResponse add(@RequestBody @Valid AddAccountRequest request)
    {
        return accountService.add(request);
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id)
    {
        accountService.delete(id);
    }

    @PutMapping("update")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody @Valid UpdateAccountRequest request)
    {
        accountService.update(request);
    }

    @GetMapping("getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllAccountResponse> getAll(@RequestParam int page, @RequestParam int size)
    {
        PageInfo pageInfo = new PageInfo(page,size);
        return accountService.getAll(pageInfo);
    }
}