package cn.xyh.testjpa;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TestJpaApplicationTests {

	@Resource
	private Cache messageCache;

	@Test
	public void contextLoads() {

		// 显示所有的Cache空间
//		System.out.println(StringUtils.join(cacheManager.getCacheNames(), ","));
//		Cache cache = cacheManager.getCache("userCache");
//		cache.put("key", "123");
//		System.out.println("缓存成功");
//		String res = cache.get("key", String.class);
//		System.out.println(res);

		messageCache.put("a", 11);
	}

	@Test
	public void tr () {
		Integer a = messageCache.get("a", Integer.class);
		System.out.println(a);
	}
}
