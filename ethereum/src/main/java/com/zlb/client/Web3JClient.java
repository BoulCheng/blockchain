package com.zlb.client;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author lubiao.zheng
 * @Description:
 * @date 2018/4/19
 */
public class Web3JClient {


    private static String ip = "http://127.0.0.1:8545/";

    private Web3JClient() {
    }

    private volatile static Web3j web3j;

    public static Web3j getClient() {
        if (web3j == null) {
            synchronized (Web3JClient.class) {
                if (web3j == null) {
                    //web3j = Web3j.build(new HttpService(ip));
                }
            }
        }

        Admin admin =Admin.build(new HttpService());
        try {
            PersonalUnlockAccount personalUnlockAccount = admin.personalUnlockAccount("a018e1604be534bda25af91b5f7a080ffe1bd1f0", "anyangleguan25",new BigInteger("300")).sendAsync().get(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        return web3j;
    }
}
