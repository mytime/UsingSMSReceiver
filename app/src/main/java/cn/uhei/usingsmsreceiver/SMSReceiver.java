package cn.uhei.usingsmsreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

import java.util.Objects;

/**
 * 短信接受器
 * 1 继承 BroadcastReceiver
 * 2 AndroidManifast中注册
 * 3 重写onReceive方法
 *
 */
public class SMSReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if(extras == null)
            return;

        Object[] pdus = (Object[]) extras.get("pdus");

        for (int i = 0; i < pdus.length; i++) {
            SmsMessage message = SmsMessage.createFromPdu((byte[]) pdus[i]);
            //发送者手机号
            String fromAddress = message.getOriginatingAddress();
            //短信内容
            String fromMessage = message.getMessageBody();
//            String fromDisplayName = fromAddress;

            System.out.format("短信发送者:%s,信息内容：%s\n",fromAddress,fromMessage);

        }
    }
}
