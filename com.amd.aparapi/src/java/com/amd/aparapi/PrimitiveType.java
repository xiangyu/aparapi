package com.amd.aparapi;

/**
 * Created with IntelliJ IDEA.
 * User: gfrost
 * Date: 5/8/13
 * Time: 8:09 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class PrimitiveType{
   static final none none = new none();
   static final v v = new v();
   static final u1 u1 = new u1();
   static final u8 u8 = new u8();
   static final u16 u16 = new u16();
   static final u32 u32 = new u32();
   //  static final u64 u64 = new u64();
   static final s8 s8 = new s8();
   static final s16 s16 = new s16();
   static final s32 s32 = new s32();
   static final s64 s64 = new s64();

   static final f16 f16 = new f16();
   static final f32 f32 = new f32();
   static final f64 f64 = new f64();
   static final ref ref = new ref();


   static PrimitiveType javaPrimitiveTypes[] = new PrimitiveType[]{
         v, u1, s8, u16, s16, s32, f32, s64, f64, ref
   };


   protected Class clazz;
   protected int javaSlots;

   Class getClazz(){
      return (clazz);
   }

   int getJavaSlots(){
      return (javaSlots);
   }

   String getJavaName(){
      if(clazz != null){
         return (clazz.getName());
      }else{
         return ("getJavaName === WHAT?");
      }
   }


   int bits;
   String prefix; // u,f,s
   char sigChar;

   public int getBits(){
      return (bits);
   }

   PrimitiveType(Class _clazz, int _bits, char _sigChar, String _prefix, int _javaSlots){
      clazz = _clazz;
      javaSlots = _javaSlots;
      sigChar = _sigChar;
      bits = _bits;
      prefix = _prefix;
   }

   public String getHSAName(){
      return (prefix + bits);
   }

   public char getSigChar(){
      return (sigChar);
   }

   public String getSig(){
      return ("" + sigChar);
   }


}

;

class u1 extends PrimitiveType{

   u1(){
      super(boolean.class, 1, 'Z', "u", 1);
   }
}

class u8 extends PrimitiveType{
   u8(){
      super(byte.class, 8, 'B', "u", 1);
   }

}

class s8 extends PrimitiveType{
   s8(){
      super(null, 8, '?', "s", -1);
   }
}

class u16 extends PrimitiveType{
   u16(){
      super(char.class, 16, 'C', "u", 1);
   }
}

class s16 extends PrimitiveType{
   s16(){
      super(short.class, 16, 'S', "s", 1);
   }
}

class f16 extends PrimitiveType{
   f16(){
      super(null, 16, '?', "f", -1);
   }
}

class u32 extends PrimitiveType{
   u32(){
      super(null, 32, '?', "u", -1);
   }
}

class s32 extends PrimitiveType{
   s32(){
      super(int.class, 32, 'I', "s", 1);
   }
}

class f32 extends PrimitiveType{
   f32(){
      super(float.class, 32, 'F', "f", 1);
   }
}

//class u64 extends PrimitiveType {
//   u64() {
//      super(null, 64, '?', "u");
//  }
//}
class ref extends PrimitiveType{
   ref(){
      super(null, 64, '?', "u", 1);
   }
}


class s64 extends PrimitiveType{
   s64(){
      super(long.class, 64, 'J', "s", 2);
   }
}

class f64 extends PrimitiveType{
   f64(){
      super(double.class, 64, 'D', "f", 2);
   }
}

class none extends PrimitiveType{
   none(){
      super(null, 0, '?', "?", -1);
   }
}

class v extends PrimitiveType{
   v(){
      super(null, 0, 'V', "v", -1);
   }
}
