package fruitbasket.com.jmessagetest.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jmessage.api.JMessageClient;
import cn.jmessage.api.group.CreateGroupResult;
import cn.jmessage.api.group.GroupInfoResult;
import cn.jmessage.api.group.GroupListResult;
import cn.jmessage.api.group.MemberListResult;
import cn.jmessage.api.user.UserGroupsResult;
import fruitbasket.com.jmessagetest.JMessageCondition;

public class GroupExample {

    protected static final Logger LOG = LoggerFactory.getLogger(GroupExample.class);

    private static final String appkey =JMessageCondition.APP_KEY;
    private static final String masterSecret =JMessageCondition.MASTER_SECRET;

    /**
     * 创建群
     */
    public static void testCreateGroup() {
        JMessageClient client = new JMessageClient(appkey, masterSecret);
        try {
            CreateGroupResult res = client.createGroup("test_user", "test_gname1", "description", "", 0, "test_user");
            LOG.info(res.getName());
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }

    /**
     * 获取群信息
     */
    public static void testGetGroupInfo() {
        JMessageClient client = new JMessageClient(appkey, masterSecret);

        try {
            GroupInfoResult res = client.getGroupInfo(JMessageCondition.GROUP_1);
            LOG.info(res.getOriginalContent());
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }

    /**
     * 获取群成员
     */
    public static void testGetGroupMemberList() {

        JMessageClient client = new JMessageClient(appkey, masterSecret);
        
        try {
            MemberListResult res = client.getGroupMembers(JMessageCondition.groupTest);
            LOG.info(res.getOriginalContent());
        
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }

    /**
     * AppKey对应的群列表
     */
    public static void testGetGroupListByAppkey() {
        JMessageClient client = new JMessageClient(appkey, masterSecret);

        try {
            GroupListResult res = client.getGroupListByAppkey(0, 30);
            LOG.info(res.getOriginalContent());
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }

    /**
     * 添加或删除群成员
     */
    public static void testManageGroup() {
        JMessageClient client = new JMessageClient(appkey, masterSecret);

        try {
            String[] addList = {};
            String[] removeList = {};
            client.addOrRemoveMembers(10003767, addList, null );
       
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }

    /**
     * 更新群信息
     */
    public static void testUpdateGroupInfo() {
        JMessageClient client = new JMessageClient(appkey, masterSecret);

        try {
            client.updateGroupInfo(10003767, "test_gname_new", "update desc", "media id");
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }
    
    /**
     * 获取用户所在的群
     */
    public static void testGetGroupsByUser() {
        JMessageClient client = new JMessageClient(appkey, masterSecret);

        try {
            UserGroupsResult result = client.getGroupListByUser(JMessageCondition.userName);
            
            int i=0;
            for(GroupInfoResult group:result.getGroups()) {
            	LOG.info("群"+(++i)+": "+group.getName());
            }
            if(i==0) {
            	LOG.info("群列表：空");
            }
            LOG.info("结果原文: "+result.getOriginalContent());
         
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }

    /**
     * 删除群
     */
    public static void testDeleteGroup() {
    	
        JMessageClient client = new JMessageClient(appkey, masterSecret);
        try {
            client.deleteGroup(JMessageCondition.groupTest);
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }

}
