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
public class Test {
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
                                             ;
                                             final int[] y = new int[1];
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
                                               y[0])/(100);
                                             System.out.println(supplyRatio + " " + demandRatio);
                                             if (supplyRatio > demandRatio * 1.1 && mode < $UTILMODES.$MAX) ++mode;
                                             else if (demandRatio > supplyRatio * 1.1 && mode > 0) --mode;
                                             }
                                             });
                                             {
                                                 for (ecor.CalibratorStack.calibrate(y[0] =
                                                        0);
                                                      y[0] <
                                                        200;
                                                      ecor.CalibratorStack.calibrate(y[0] +=
                                                        1)) {
                                                     
                                                 }
                                             }
                                             ecor.CalibratorStack.pop();
                                             ;
    }
    public Test() { super(); }
    public static final String jlc$CompilerVersion$jl7 =
      "2.6.1";
    public static final long jlc$SourceLastModified$jl7 =
      1528023127984L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "b7Pb5x/nbVwa1A0AAA==");
}
