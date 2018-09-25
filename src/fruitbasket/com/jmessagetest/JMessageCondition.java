package fruitbasket.com.jmessagetest;

public class JMessageCondition {
	private static final JMessageCondition instance=new JMessageCondition();
	
	//推送服务主机
	public static final String PUSH_HOST="https://api.jpush.cn";
	
	//北京的推送服务主机
	///不能使用
	public static final String PUSH_HOST_BJ="https://bjapi.jiguang.cn";
	public static final String PUSH_HOST_BJ_PUSH=PUSH_HOST_BJ+"/v3/push";
	
	//JMessage
	public static final String APP_KEY="6405d90516a86262e2f52dad";
	public static final String MASTER_SECRET="46aa7d4498dcf51a5cd5422f";
	
	//中兴
	public static final String REGISTRATION_ID_1="190e35f7e01704b2f97";
	
	//用户信息
	public static final int USER_1=0;
	private static final String USER_NAME_1 ="zhouxj1";
	private static final String PASSWORD_1 ="123456";

	public static final int USER_2=1;
	private static final String USER_NAME_2="zhouxj2";
	private static final String PASSWORD_2="123456";

	public static final int USER_3=2;
	private static final String USER_NAME_3="zhouxj3";
	private static final String PASSWORD_3="123456";

	public static final int USER_4=3;
	private static final String USER_NAME_4="zhouxj4";
	private static final String PASSWORD_4="123456";

	//当前用户
	public static String userName=USER_NAME_1;
	public static String userPassword=PASSWORD_1;

	//好友用户
	public static String otherName=USER_NAME_1;
	public static String otherPassword=USER_NAME_1;

	//群ID
	public static final long GROUP_1=26886409;//私有
	public static final long GROUP_2=26886413;//公有
	public static long groupTest=27188083;

	
	private JMessageCondition() {}
	
	public JMessageCondition getInstance() {
		return instance;
	}
	
	/**
	 * 设置当前用户名和密码
	 * @param command
	 */
	public static void setMyUser(int command){
		if(command==0){
			userName=JMessageCondition.USER_NAME_1;
			userPassword =JMessageCondition.PASSWORD_1;
		}
		else if(command==1){
			userName=JMessageCondition.USER_NAME_2;
			userPassword =JMessageCondition.PASSWORD_2;
		}
		else if(command==2){
			userName=JMessageCondition.USER_NAME_3;
			userPassword =JMessageCondition.PASSWORD_3;
		}
		else if(command==3){
			userName=JMessageCondition.USER_NAME_4;
			userPassword =JMessageCondition.PASSWORD_4;
		}
		else{
			
		}
	}

	/**
	 * 设置其他用户的名字和密码
	 * @param command
	 */
	public static void setOtherUser(int command){
		if(command==0){
			otherName=JMessageCondition.USER_NAME_1;
			otherPassword =JMessageCondition.PASSWORD_1;
		}
		else if(command==1){
			otherName=JMessageCondition.USER_NAME_2;
			otherPassword=JMessageCondition.PASSWORD_2;
		}
		else if(command==2){
			otherName=JMessageCondition.USER_NAME_3;
			otherPassword=JMessageCondition.PASSWORD_3;
		}
		else if(command==3){
			otherName=JMessageCondition.USER_NAME_4;
			otherPassword=JMessageCondition.PASSWORD_4;
		}
		else{
			
		}
	}

}
