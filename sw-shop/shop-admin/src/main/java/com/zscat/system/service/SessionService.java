package com.zscat.system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zscat.system.domain.UserOnline;

@Service
public interface SessionService {
	List<UserOnline> list();
}
