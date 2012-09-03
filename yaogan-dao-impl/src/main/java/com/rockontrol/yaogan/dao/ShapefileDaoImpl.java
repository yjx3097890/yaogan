package com.rockontrol.yaogan.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.rockontrol.yaogan.model.Shapefile;

@Repository("shapefileDao")
public class ShapefileDaoImpl extends BaseDaoImpl<Shapefile> implements IShapefileDao {

   @SuppressWarnings("unchecked")
   @Override
   public List<String> getAvailableTimesOfPlace(Long placeId) {
      Query query = getSession().getNamedQuery("Shapefile.getAvailableTimesOfPlace");
      query.setLong("placeId", placeId);
      return query.list();
   }

   @SuppressWarnings("unchecked")
   @Override
   public List<Shapefile> getShapefiles(Long placeId, String time) {
      Query query = getSession().getNamedQuery("Shapefile.getShapefilesByPlaceAndTime");
      query.setLong("placeId", placeId);
      query.setString("time", time);
      return query.list();
   }

}
