import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
class $UTILMODES{
    public static final int $MAX = 2;
    public static final int high = 2;
    public static final int low = 1;
    public static final int mid = 0;
}
public class ElectricEngine {
    public static void main(String[] args) { final int[] x = new int[1];
                                             ecor.CalibratorStack.push(new ecor.Calibrator() {
                                             double supplyRatio = 0;
                                             public int mode = $UTILMODES.$MAX;
                                             public int getMode(int max) {
                                             return mode;
                                             }
                                             public int supply() {
                                             return ecor.bsupply.BatterySupply.sharedSupply().getRemainingCapacity();}
                                             private double supplyLimit = (ecor.bsupply.BatterySupply.sharedSupply().getRemainingCapacity()) *
                                               0.6;
                                             private int initialSupply = this.supply();
                                             public Object calibrate(Object input) {
                                             supplyRatio = (supplyLimit - (initialSupply - this.supply()))/supplyLimit;
                                             return input;
                                             }
                                             public void adjust() {
                                             double demandRatio = (double)(100 -
                                               x[0])/(100);
                                             System.out.println(supplyRatio + " " + demandRatio);
                                             if (supplyRatio > demandRatio * 1.1 && mode < $UTILMODES.$MAX) ++mode;
                                             else if (demandRatio > supplyRatio * 1.1 && mode > 0) --mode;
                                             }
                                             });
                                             {
                                                 for (ecor.CalibratorStack.calibrate(x[0] =
                                                        0);
                                                      x[0] <
                                                        100;
                                                      ecor.CalibratorStack.calibrate(x[0] +=
                                                        1)) {
                                                     
                                                 }
                                             }
                                             ecor.CalibratorStack.pop();
                                             ecor.bsupply.BatterySupply.sharedSupply().peak("power", 15);
                                             ecor.bsupply.BatterySupply.sharedSupply().provide("traction", 150);
                                             ; }
    public ElectricEngine() { super(); }
    public static final String jlc$CompilerVersion$jl7 =
      "2.6.1";
    public static final long jlc$SourceLastModified$jl7 =
      1528390963980L;
    public static final String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAK1Xa2wUVRS+u32XQh88xEpLXyClsAs/0ECJWNaFFre0oUhi" +
       "qZTbmbvbobMzw5277bZYeSSmxB/EaEEw2h8GRJRXjASNIekvgWBMIMbEH4L+" +
       "kogk8gdNUPHce3d3dqfbGhObzO3Mueece17fuWfP3kd5NkVNlqkPR3ST+Uic" +
       "+fboa3xs2CK2b0toTSemNlEDOrbt7UDrVeoulj589GZ/mRfld6O52DBMhplm" +
       "GvY2Ypv6IFFDqNShBnUStRkqC+3Bg9gfY5ruD2k2aw6hWWmiDDWEkib4wQQ/" +
       "mOAXJvhbHC4Qmk2MWDTAJbDB7L3oNeQJoXxL4eYxVJupxMIURxNqOoUHoKGQ" +
       "f+8Ap4RwnKKalO/S5ykOH23yj7+zq+zTHFTajUo1o4ubo4ARDA7pRiVREu0j" +
       "1G5RVaJ2o3KDELWLUA3r2oiwuxtV2FrEwCxGSSpInBizCBVnOpErUbhvNKYw" +
       "k6bcC2tEV5NfeWEdR8DXBY6v0sNNnA4OFmtgGA1jhSRFcgc0Q2VosVsi5WPD" +
       "i8AAogVRwvrN1FG5BgYCqpC507ER8XcxqhkRYM0zY3AKQ5XTKuWxtrAygCOk" +
       "l6GFbr5OuQVcRSIQXISh+W42oQmyVOnKUlp+7m9df2Sf0Wp4hc0qUXRufyEI" +
       "VbuEtpEwocRQiBQsWR46hhdcOexFCJjnu5glz+VXHzy/onrymuR5KgtPR98e" +
       "orBe5WTfnJuLAo1rc7gZhZZpazz5GZ6L8u9M7DTHLUDegpRGvulLbk5u++rl" +
       "Ax+Te15U3IbyFVOPRaGOyhUzamk6oZuJQShmRG1DRcRQA2K/DRXAe0gziKR2" +
       "hMM2YW0oVxekfFN8Q4jCoIKHqADeNSNsJt8tzPrFe9xCCBXAg0rgKULyT/xn" +
       "KPDCup5OanKn7Z5goGNlO7ahFKJQQj3cPo4LwGZP63Af1dQApj3QAxSoGyVo" +
       "RMASH1FM6/9RE+fWlg15PBDIRW4Y64CAVlNXCe1VxmMbgw/O997wpso64SdD" +
       "czLVIo9HqJvHa17mBCI6ANiErlXS2PXKlt2H63KgGKyhXAgHZ60DSxKHBhUz" +
       "4AC4TbQpBapo4Qc7x3x/nN4gq8g/fbfNKo0mjw8d3LF/lRd5M9smdwJIxVy8" +
       "kze7VFNrcMMlm97SsbsPLxwbNR3gZPThBJ6nSnI81rnDTU2FqNDhHPXLa/Cl" +
       "3iujDV6UCyCHxsYwBBh6RrX7jAxcNid7HPclDxwOmzSKdb6VbEzFrJ+aQw5F" +
       "1MEcvlTIkuAJdBko2uOmLyZPXHq3aa03vZOWpt1NXYRJXJY7+d9OCQH6D8c7" +
       "3z56f2ynSD5w1Gc7oIGvAShfyAZE7PVre7+/c/vkt16nYBhcV7E+XVPioGOp" +
       "cwpgmBciT2vDS0bUVLWwhvt0wuvuz9Ilqy/9eqRMJkoHSjLPK/5dgUN/ciM6" +
       "cGPX79VCjUfhd4jjucMmAzDX0dxCKR7mdsQP3qo6cRW/Dy0O2oqtjRDRKZDw" +
       "DInQ+0RGGsW60rW3ii811pS9uKAsTHyJj1qxNvDlaRk3/rrMxUlR1XTXgrjS" +
       "Th4an1A7Tq2WsKvIbLVBmCTOfffX177jP17P0heKmGmt1Mkg0dPO5HCvyoB7" +
       "u7gxnaJ/48wnl9nNpnXyyOXTI90tePXQL5Xbn+vf/R9AvtjlvFvlmfaz1zcv" +
       "Vd7yopwUvqcMAZlCzelhgEMpganF4AHllGKRxmphQDmEo4ynYRk8sxJXhPjP" +
       "d+dafJ2XQGPWjHpFRgEOtpin4q7C8aQCvmT6IIrKlBf1xIf13+yfqP8JUtmN" +
       "CjUbRrwWGskyOaTJ/Hb2zr1bs6vOiw6V24dt6aV75Jo6UWUMSsLJklRQKnkM" +
       "amYKimCdD0OxgBifq3xyrrIsSyIlOAOK2vmygaHcKLRTCE/jDLM71aIwTgwm" +
       "5h3/aMWdgffunpO16R6OXMzk8Pgbj31Hxr1pE2T9lCEuXUZOkcLG2TIaj+HP" +
       "A8/f/OEOcIKcIioCiVGmJjXLWBZHdO1MZokjNv18YfTLj0bHvImAPAuxGDQ1" +
       "NUtjmXK9W1aW4MsJLo4ymovlbjX1GXEWvy2SuIvJXxe9yoWJLVv3PXjmlABx" +
       "HvwqGRkRsyhUjLzFUtitnVZbUld+a+OjOReLliTdzLjfXLYtzn4NBKMWE417" +
       "5PMnPlt/euK2uIf+AXz+5Ur0DQAA");
}
