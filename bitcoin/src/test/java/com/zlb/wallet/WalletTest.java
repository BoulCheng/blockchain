package com.zlb.wallet;

import com.zlb.util.BtcAddressUtils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lubiao.zheng
 * @Description:
 * @date 2018/4/18
 */
public class WalletTest {

    //http://lenschulwitz.com/base58
    @Test
    public void getAddress() {
        Wallet wallet = new Wallet();
        try {
            String publicKey = BtcAddressUtils.bytesToHexString(wallet.getPublicKey());
            System.out.println("publicKey:" + publicKey);
            String address = wallet.getAddress();
            System.out.println("address:" + address);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}