package fruitbasket.com.jmessagetest;

import java.util.ArrayList;
import java.util.List;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jmessage.api.JMessageClient;
import cn.jmessage.api.common.model.RegisterInfo;
import cn.jmessage.api.message.MessageListResult;
import cn.jmessage.api.reportv2.ReportClient;
import fruitbasket.com.jmessagetest.core.UserExample;

public class JMessageMain {
	
	public static void main(String[] args) {
		System.out.println("JMessage main()");
		
		JMessageCondition.setMyUser(JMessageCondition.USER_4);
		JMessageCondition.setOtherUser(JMessageCondition.USER_3);
		
		//消息管理
		//MessageExample.testSendSingleTextByAdmin();
		
		//用户管理
		//UserExample.updateUserInfo();
		//UserExample.testAddFriends();
		//UserExample.testDeleteFriends();
		//UserExample.testRegisterUsers();
		
		//群组管理
		//GroupExample.testDeleteGroup();
		//GroupExample.testGetGroupsByUser();
		//GroupExample.testGetGroupMemberList();
		
		//test1();
		test2("eff750a5e3bf5abf6797bbe3","aabceb8197a4ae9a77f0b1b1");
	}
	
	public static void test1() {
        JMessageClient client = 
        		new JMessageClient(
        				JMessageCondition.APP_KEY, 
        				JMessageCondition.MASTER_SECRET
        		);
        
        try {
            List<RegisterInfo> users = new ArrayList<RegisterInfo>();

            RegisterInfo user1 = RegisterInfo.newBuilder()
                    .setUsername("zhouxj4")
                    .setPassword("123456")
                    .build();
            RegisterInfo user2 = RegisterInfo.newBuilder()
                    .setUsername("zhouxj6")
                    .setPassword("123456")
                    .build();

            users.add(user1);
            users.add(user2);

            RegisterInfo[] regUsers = new RegisterInfo[users.size()];
            String res = client.registerUsers(users.toArray(regUsers));
            System.out.println(res);
        } catch (APIConnectionException e) {
        	System.out.println("APIConnectionException");
        } catch (APIRequestException e) {
        	System.out.println("APIRequestException");
        }
    }
	
	public static void test2(String appKey,String masterSecret) {
		
		final long groupId=12211188;//群Id
		final int count=5;//需要获取的聊天消息数量
		final String beginTime="2018-07-24 12:00:00";//开始时间
		final String endTime="2018-07-28 12:00:00";//结束时间
		
		ReportClient client = new ReportClient(appKey,masterSecret);
		
		try {
			MessageListResult result=client.v2GetGroupMessageList(
					groupId,
					count,
					beginTime,
					endTime
			);
			
			System.out.println(result.toString());;
		} catch (APIConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (APIRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
