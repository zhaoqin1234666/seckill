package cn.zhaoqin.seckill.redis;

public class AccessKey extends BasePrefix{

	private AccessKey( String prefix) {
		super(prefix);
	}
	
	public static AccessKey withExpire = new AccessKey("access");

}
