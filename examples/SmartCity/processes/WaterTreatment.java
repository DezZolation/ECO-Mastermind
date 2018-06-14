class $UTILMODES{
    public static final int $MAX = 2;
    public static final int high = 2;
    public static final int low = 1;
    public static final int mid = 0;
}
public class WaterTreatment {
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
                                             //System.out.println(supplyRatio + " " + demandRatio);
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
                                             ecor.bsupply.BatterySupply.sharedSupply().peak("power", 60);
                                             ecor.bsupply.BatterySupply.sharedSupply().peak("bandwidth", 10);
                                             ecor.bsupply.BatterySupply.sharedSupply().provide("water", 70);
                                             ; }
    public WaterTreatment() { super(); }
    public static final String jlc$CompilerVersion$jl7 =
      "2.6.1";
    public static final long jlc$SourceLastModified$jl7 =
      1528963231328L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "P1t7auKWuIf+AU4EyRH0DQAA");
}
