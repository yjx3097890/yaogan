package org.yaogan.gis.util;

public interface FactorCaculateConstant {
   public static final double AF_MAX = Math.sqrt(35.0);
   // 生物丰度参数
   public static final double ABIO = 1; /* 100 / Math.sqrt(35.0); */

   public static final double AVEG = 1; /* 100 / Math.sqrt(38); */
   public static final double AERO_MAX = (100 + Math.sqrt(100 * 100 - 20)) / 2;
   public static final double AERO = 1;/* 100 / AERO_MAX; */

   // 土地环境指数
   public static final double ASUS = 1;
   public static final double ASUC = 1;
   public static final double AUWC = 1;

   public static final String LAND_TYPE_FORST = "林地";
   public static final String LAND_TYPE_LAWN = "草地";
   public static final String LAND_TYPE_FARM = "耕地";
   public static final String LAND_TYPE_WET = "水域湿地";
   public static final String LAND_TYPE_CONSTRUCTION = "建设用地";
   public static final String LAND_TYPE_NOT_USED = "未利用地";

   public static final String LAND_DETERIORATED_SLIGHT = "轻度侵蚀";
   public static final String LAND_DETERIORATED_PART = "中度侵蚀";
   public static final String LAND_DETERIORATED_SERIOUS = "重度侵蚀";

}
