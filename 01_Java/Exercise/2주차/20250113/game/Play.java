public class Play {
    public static void main(String[] var0) {
       Unit[] var1 = new Unit[]{new Marine("m1"), new Zealot("z1"), new Medic("me1")};
       Unit[] var2 = var1;
       int var3 = var1.length;
 
       for(int var4 = 0; var4 < var3; ++var4) {
          Unit var5 = var2[var4];
          if (var5 instanceof Attackable) {
             ((Attackable)var5).attack();
          }
       }
    }
 }
 