package leaderment.com.gateway.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 默认降级处理
 */
@RestController
@SuppressWarnings("all")
public class DefaultHystrixController {
	@Autowired
	RedisTemplate redisTemplate;

	// 解决redis客户端显示乱码问题
	@Autowired(required = false)
	public void setRedisTemplate(RedisTemplate redisTemplate) {
		RedisSerializer stringSerializer = new StringRedisSerializer();
		redisTemplate.setKeySerializer(stringSerializer);
		redisTemplate.setValueSerializer(stringSerializer);
		redisTemplate.setHashKeySerializer(stringSerializer);
		redisTemplate.setHashValueSerializer(stringSerializer);
		this.redisTemplate = redisTemplate;
	}

	@RequestMapping("/fallback")
	public Map<String, String> defaultfallback() {
		System.out.println("降级操作...");
		Map<String, String> map = new HashMap<>();
		map.put("resultCode", "fail");
		map.put("resultMessage", "服务异常");
		map.put("resultObj", "null");
		return map;
	}
}