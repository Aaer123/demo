package com.example.demo.mapper;

import com.example.demo.domain.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {

    void rolein(Role role);
}
