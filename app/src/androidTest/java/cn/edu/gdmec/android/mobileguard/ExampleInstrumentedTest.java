//package cn.edu.gdmec.android.mobileguard;
//
//import android.content.Context;
//import android.support.test.InstrumentationRegistry;
//import android.support.test.runner.AndroidJUnit4;
//
//package cn.edu.gdmec.android.mobileguard;
//
//import android.content.Context;
//import android.content.Intent;
//import android.support.test.InstrumentationRegistry;
//import android.support.test.filters.SdkSuppress;
//import android.support.test.runner.AndroidJUnit4;
//import android.support.test.uiautomator.By;
//import android.support.test.uiautomator.UiDevice;
//import android.support.test.uiautomator.UiObject;
//import android.support.test.uiautomator.UiObject2;
//import android.support.test.uiautomator.UiObjectNotFoundException;
//import android.support.test.uiautomator.UiScrollable;
//import android.support.test.uiautomator.UiSelector;
//import android.support.test.uiautomator.Until;
//import android.widget.Button;
//import android.widget.CheckBox;
//import android.widget.EditText;
//
//import org.junit.Before;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import static java.lang.Thread.sleep;
//import static org.hamcrest.core.IsNull.notNullValue;
//import static org.junit.Assert.*;
//
//@RunWith(AndroidJUnit4.class)
//@SdkSuppress(minSdkVersion = 18)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class ExampleInstrumentedTest {
//    //包名
//    private static final String BASIC_SAMPLE_PACKAGE
//            = "cn.edu.gdmec.android.mobileguard";
//    //超时时间
//    private static final int LAUNCH_TIMEOUT = 5000;
//    //设备实例
//    private UiDevice mDevice;
//    @Before
//    public void startMainActivityFromHomeScreen() {
//        // 初始化 UiDevice 实例
//        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
//
//        // 按home键，返回到主界面
//        mDevice.pressHome();
//
//        // 等待应用装载运行
//        final String launcherPackage = mDevice.getLauncherPackageName();
//        assertThat(launcherPackage, notNullValue());
//        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)),
//                LAUNCH_TIMEOUT);
//
//        // 启动应用
//        Context context = InstrumentationRegistry.getContext();
//        final Intent intent = context.getPackageManager()
//                .getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE);
//        // 开始新的acivity，移除以前的所有实例
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        context.startActivity(intent);
//
//        // 等待应用启动
//        mDevice.wait(Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
//                LAUNCH_TIMEOUT);
//    }
//
//    public boolean waitForUiObject(UiSelector selector,double timeOut) {//等待对象出现
//        Date start = new Date();
//        boolean result = false;
//        while(!result){
//            try {
//                sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            UiObject it = mDevice.findObject(selector);
//            if (it.exists()) {
//                result = true;
//                break;
//            }
//            Date end = new Date();
//            long time = end.getTime() - start.getTime();
//            if (time>timeOut) {
//                break;
//            }
//        }
//        return result;
//    }
//    //@Test
//    public  void t0SetupPermission() throws UiObjectNotFoundException, InterruptedException {
//        UiDevice.getInstance().pressHome();
//        sleep(200);
//        mDevice.findObject(new UiSelector().textStartsWith("设置")).clickAndWaitForNewWindow();
//        mDevice.swipe(700,700,700,0,100);
//        mDevice.swipe(700,700,700,0,100);
//        mDevice.findObject(new UiSelector().textStartsWith("应用")).clickAndWaitForNewWindow();
//        mDevice.findObject(new UiSelector().textStartsWith("MobileGuard")).clickAndWaitForNewWindow();
//        mDevice.findObject(new UiSelector().textStartsWith("权限")).clickAndWaitForNewWindow();
//
//        List<UiObject2> results;
//        results = mDevice.findObjects(By.clazz(CheckBox.class));
//        for(UiObject2 item : results){
//            item.click();
//        }
//        UiDevice.getInstance().pressHome();
//
//        //可listview滚动搜索
////        UiScrollable settingsItem = new UiScrollable(new UiSelector()
////                .className("android.widget.ListView"));
////        UiObject about = settingsItem.getChildByText(new UiSelector()
////                .className("android.widget.LinearLayout"), "About tablet");
////        about.click();
//    }
//    @Test
//    public void t01ShowUpdateDialog() throws UiObjectNotFoundException {
//        UiObject result = mDevice.findObject(new UiSelector().textContains("2.0"));
//        String str = null;
//        str = result.getText();
//        assertNotNull("检查到新版本",result);
//    }
//
//    @Test
//    public void t02ShowMainActivity() throws UiObjectNotFoundException {
//        // 使用UIselector找到包含『版本号』文字的UI组件
//        UiObject result = mDevice.findObject(new UiSelector().textStartsWith("暂不升级"));
//        result.clickAndWaitForNewWindow();
//        result = mDevice.findObject(new UiSelector().textStartsWith("手机防盗"));
//        String str = result.getText();
//        assertNotNull("出现主界面手机防盗",result);
//    }
//
//    @Test
//    public void t03SetupPwd() throws Exception{
//        UiObject result = mDevice.findObject(new UiSelector().textStartsWith("暂不升级"));
//        result.clickAndWaitForNewWindow();
//        result = mDevice.findObject(new UiSelector().textStartsWith("手机防盗"));
//        result.clickAndWaitForNewWindow();
//        List<UiObject2> results;
//        results = mDevice.findObjects(By.clazz(EditText.class));
//        UiObject2 pwd1 = results.get(0);
//        pwd1.setText("1");
//        UiObject2 pwd2 = results.get(1);
//        pwd2.setText("1");
//        result = mDevice.findObject(new UiSelector().textStartsWith("确认"));
//        result.clickAndWaitForNewWindow();
//    }
//
//    @Test
//    public void t04EnterPwd() throws Exception{
//        UiObject result = mDevice.findObject(new UiSelector().textStartsWith("暂不升级"));
//        result.clickAndWaitForNewWindow();
//        result = mDevice.findObject(new UiSelector().textStartsWith("手机防盗"));
//        result.clickAndWaitForNewWindow();
//        List<UiObject2> results;
//        results = mDevice.findObjects(By.clazz(EditText.class));
//        UiObject2 pwd1 = results.get(0);
//        pwd1.setText("1");
//        result = mDevice.findObject(new UiSelector().textStartsWith("确认"));
//        result.clickAndWaitForNewWindow();
//    }
//
//    @Test
//    public void t05SetupFling() throws Exception{
//        UiObject result = mDevice.findObject(new UiSelector().textStartsWith("暂不升级"));
//        result.clickAndWaitForNewWindow();
//        result = mDevice.findObject(new UiSelector().textStartsWith("手机防盗"));
//        result.clickAndWaitForNewWindow();
//        List<UiObject2> results;
//        results = mDevice.findObjects(By.clazz(EditText.class));
//        UiObject2 pwd1 = results.get(0);
//        pwd1.setText("1");
//        result = mDevice.findObject(new UiSelector().textStartsWith("确认"));
//        result.clickAndWaitForNewWindow();
//        mDevice.wait(Until.hasObject(By.textStartsWith("手机防盗向导")),LAUNCH_TIMEOUT);
//        mDevice.swipe(400,300,0,300,100);
//        mDevice.wait(Until.hasObject(By.textStartsWith("SIM卡绑定")),LAUNCH_TIMEOUT);
//        mDevice.swipe(400,300,0,300,100);
//        mDevice.wait(Until.hasObject(By.textStartsWith("选择安全联系人")),LAUNCH_TIMEOUT);
//        mDevice.swipe(400,300,0,300,100);
//        result = mDevice.findObject(new UiSelector().textStartsWith("恭喜"));
//        String str = result.getText();
//        assertNotNull("手机防盗向导",result);
//    }
//
//    @Test
//    public void t06BindSimNotYet() throws UiObjectNotFoundException {
//        UiObject result = mDevice.findObject(new UiSelector().textStartsWith("暂不升级"));
//        result.clickAndWaitForNewWindow();
//        result = mDevice.findObject(new UiSelector().textStartsWith("手机防盗"));
//        result.clickAndWaitForNewWindow();
//        List<UiObject2> results;
//        results = mDevice.findObjects(By.clazz(EditText.class));
//        UiObject2 pwd1 = results.get(0);
//        pwd1.setText("1");
//        UiObject2 pwd2 = results.get(1);
//        pwd2.setText("1");
//        result = mDevice.findObject(new UiSelector().textStartsWith("确认"));
//        result.clickAndWaitForNewWindow();
//
//        results = mDevice.findObjects(By.clazz(EditText.class));
//        UiObject2 pwd = results.get(0);
//        pwd.setText("1");
//        result = mDevice.findObject(new UiSelector().textStartsWith("确认"));
//        result.clickAndWaitForNewWindow();
//        mDevice.wait(Until.hasObject(By.textStartsWith("手机防盗向导")),LAUNCH_TIMEOUT);
//        mDevice.swipe(400,300,0,300,100);
//        mDevice.swipe(400,300,0,300,100);
//        mDevice.swipe(400,300,0,300,100);
//        mDevice.swipe(400,300,0,300,100);
//        mDevice.wait(Until.hasObject(By.textStartsWith("SIM卡绑定")),LAUNCH_TIMEOUT);
//        result = mDevice.findObject(new UiSelector().textStartsWith("SIM卡绑定"));
//        String str = result.getText();
//    }
//
//    @Test
//    public void t07BindSimOk() throws UiObjectNotFoundException {
//        UiObject result = mDevice.findObject(new UiSelector().textStartsWith("暂不升级"));
//        result.clickAndWaitForNewWindow();
//        result = mDevice.findObject(new UiSelector().textStartsWith("手机防盗"));
//        result.clickAndWaitForNewWindow();
//        List<UiObject2> results;
//        results = mDevice.findObjects(By.clazz(EditText.class));
//        UiObject2 pwd = results.get(0);
//        pwd.setText("1");
//        result = mDevice.findObject(new UiSelector().textStartsWith("确认"));
//        result.clickAndWaitForNewWindow();
//        mDevice.wait(Until.hasObject(By.textStartsWith("手机防盗向导")),LAUNCH_TIMEOUT);
//        mDevice.swipe(400,300,0,300,100);
//        mDevice.wait(Until.hasObject(By.textStartsWith("SIM卡绑定")),LAUNCH_TIMEOUT);
//        results = mDevice.findObjects(By.clazz(Button.class));
//        UiObject2 btn = results.get(0);
//        assertTrue("bind sim button is enabled",btn.isEnabled());
//        btn.click();
//        assertFalse("bind sim button is not enabled ",btn.isEnabled());
//    }
//    @Test
//    public void t08SelectSecurityContacts() throws UiObjectNotFoundException {
//        UiObject result = mDevice.findObject(new UiSelector().textStartsWith("暂不升级"));
//        result.clickAndWaitForNewWindow();
//        result = mDevice.findObject(new UiSelector().textStartsWith("手机防盗"));
//        result.clickAndWaitForNewWindow();
//        List<UiObject2> results;
//        results = mDevice.findObjects(By.clazz(EditText.class));
//        UiObject2 pwd = results.get(0);
//        pwd.setText("1");
//        result = mDevice.findObject(new UiSelector().textStartsWith("确认"));
//        result.clickAndWaitForNewWindow();
//        mDevice.wait(Until.hasObject(By.textStartsWith("手机防盗向导")),LAUNCH_TIMEOUT);
//        mDevice.swipe(400,300,0,300,100);
//        mDevice.wait(Until.hasObject(By.textStartsWith("SIM卡绑定")),LAUNCH_TIMEOUT);
//        mDevice.swipe(400,300,0,300,100);
//        mDevice.wait(Until.hasObject(By.textStartsWith("选择安全联系人")),LAUNCH_TIMEOUT);
//        result = mDevice.findObject(new UiSelector().className("android.widget.Button"));
//        result.clickAndWaitForNewWindow();
//        UiScrollable contactList = new UiScrollable( new UiSelector().className("android.widget.ListView"));
//        UiObject note = contactList.getChildByText(new UiSelector().className("android.widget.TextView"), "York Cui", true);
//        note.clickAndWaitForNewWindow();
//        result = mDevice.findObject(new UiSelector().className("android.widget.EditText"));
//        String str = result.getText();
//        assertEquals("security contact phonenumber",str,"1 376-079-5885");
//    }
//
//    @Test
//    public void t09ConfirmDeviceAdmin() throws UiObjectNotFoundException {
//        UiObject result = mDevice.findObject(new UiSelector().textStartsWith("激活此设备管理员"));
//        String str = result.getText();
//        result.clickAndWaitForNewWindow();
//        result = mDevice.findObject(new UiSelector().textStartsWith("手机防盗"));
//        str = result.getText();
//    }
//    @Test
//    public void t10SetupTheftGuard() throws UiObjectNotFoundException {
//        UiObject result = mDevice.findObject(new UiSelector().textStartsWith("手机防盗"));
//        result.clickAndWaitForNewWindow();
//        List<UiObject2> results;
//        results = mDevice.findObjects(By.clazz(EditText.class));
//        UiObject2 pwd1 = results.get(0);
//        pwd1.setText("1");
//        UiObject2 pwd2 = results.get(1);
//        pwd2.setText("1");
//        result = mDevice.findObject(new UiSelector().textStartsWith("确认"));
//        result.clickAndWaitForNewWindow();
//
//        results = mDevice.findObjects(By.clazz(EditText.class));
//        UiObject2 pwd = results.get(0);
//        pwd.setText("1");
//        result = mDevice.findObject(new UiSelector().textStartsWith("确认"));
//        result.clickAndWaitForNewWindow();
//        mDevice.wait(Until.hasObject(By.textStartsWith("手机防盗向导")),LAUNCH_TIMEOUT);
//        mDevice.swipe(400,300,0,300,100);
//        mDevice.wait(Until.hasObject(By.textStartsWith("SIM卡绑定")),LAUNCH_TIMEOUT);
//        results = mDevice.findObjects(By.clazz(Button.class));
//        UiObject2 btn = results.get(0);
//        btn.click();
//        mDevice.swipe(400,300,0,300,100);
//        result = mDevice.findObject(new UiSelector().className("android.widget.EditText"));
//        result.setText("110");
//        mDevice.swipe(400,300,0,300,100);
//        result = mDevice.findObject(new UiSelector().textStartsWith("防盗保护已经开启"));
//        String str = result.getText();
//        result = mDevice.findObject(new UiSelector().className("android.widget.ToggleButton"));
//        result.click();
//        result = mDevice.findObject(new UiSelector().textStartsWith("防盗保护没有开启"));
//        str = result.getText();
//        result = mDevice.findObject(new UiSelector().className("android.widget.ToggleButton"));
//        result.click();
//        mDevice.swipe(400,300,0,300,100);
//    }
//    @Test
//    public void t11ReSetupTheftGuard() throws UiObjectNotFoundException {
//        UiObject result = mDevice.findObject(new UiSelector().textStartsWith("手机防盗"));
//        result.clickAndWaitForNewWindow();
//        List<UiObject2> results;
//        results = mDevice.findObjects(By.clazz(EditText.class));
//        UiObject2 pwd = results.get(0);
//        pwd.setText("1");
//        result = mDevice.findObject(new UiSelector().textStartsWith("确认"));
//        result.clickAndWaitForNewWindow();
//        result = mDevice.findObject(new UiSelector().textStartsWith("重新进入设置向导"));
//        result.click();
//        result = mDevice.findObject(new UiSelector().textStartsWith("手机防盗向导"));
//        String str = result.getText();
//    }
//
//}