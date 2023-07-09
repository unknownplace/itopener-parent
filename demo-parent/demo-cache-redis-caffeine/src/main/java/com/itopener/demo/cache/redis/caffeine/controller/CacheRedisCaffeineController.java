package com.itopener.demo.cache.redis.caffeine.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itopener.demo.cache.redis.caffeine.service.CacheRedisCaffeineService;
import com.itopener.demo.cache.redis.caffeine.vo.UserVO;
import com.itopener.framework.ResultMap;

@RestController
@RequestMapping("user")
public class CacheRedisCaffeineController {

	@Resource
	private CacheRedisCaffeineService cacheRedisCaffeineService;
	
	@GetMapping("id/{id}")
	public ResultMap get(@PathVariable long id) {
		UserVO user = cacheRedisCaffeineService.get(id);
		return ResultMap.buildSuccess().put("user", user);
	}
	
	@GetMapping("name/{name}")
	public ResultMap get(@PathVariable String name) {
		UserVO user = cacheRedisCaffeineService.get(name);
		return ResultMap.buildSuccess().put("user", user);
	}
	
	@GetMapping("update/{id}")
	public ResultMap update(@PathVariable long id) {
		UserVO user = cacheRedisCaffeineService.get(id);
		cacheRedisCaffeineService.update(user);
		return ResultMap.buildSuccess().put("user", user);
	}
	
	@GetMapping("delete/{id}")
	public ResultMap delete(@PathVariable long id) {
		cacheRedisCaffeineService.delete(id);
		return ResultMap.buildSuccess();
	}

	@GetMapping("getByNull/{id}")
	public ResultMap getByNull(@PathVariable long id) {
		UserVO user = cacheRedisCaffeineService.getForNull(id);
		return ResultMap.buildSuccess().put("user", user);
	}

	@GetMapping("getForNullWithNoSync/{id}")
	public ResultMap getForNullWithNoSync(@PathVariable long id) {
		UserVO user = cacheRedisCaffeineService.getForNullWithNoSync(id);
		return ResultMap.buildSuccess().put("user", user);
	}
}
