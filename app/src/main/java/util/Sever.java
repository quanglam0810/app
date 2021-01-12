package util;

public class Sever {
    public static String localhost = "192.168.1.3:8080";
    public static String producttypelink = "http://"+localhost+ "/Sever/getdevicetype.php";
    public static String newproduct = "http://"+localhost+"/Sever/getnewproduct.php";
    public static String product = "http://"+localhost+"/Sever/getproduct.php";
    public static String billlink = "http://"+localhost+"/Sever/customerinformation.php";
    public static String orderdetaillink = "http://"+localhost+"/Sever/orderdetail.php";
    public static String signup = "http://"+localhost+"/Sever/signup.php";
    public static String login = "http://"+localhost+"/Sever/login.php";
    public static String checkuser = "http://"+localhost+"/Sever/checkuser.php";
}
