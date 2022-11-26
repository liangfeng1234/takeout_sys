package com.zlji.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlji.reggie.entity.AddressBook;
import com.zlji.reggie.mapper.AddressBookMapper;
import com.zlji.reggie.service.AddressBookService;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService{
}
