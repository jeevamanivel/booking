package com.sap.booking.controller.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sap.booking.model.ShowDTO;

@Repository
public interface ShowRepository extends CrudRepository<ShowDTO, Integer>{
	
	@Query("select show from ShowDTO show, PartnerDTO partner where show.movieId=:movieId and trunc(show.showTime)=trunc(:date) and"
			+ "show.partnerId=partner.partnerId and partner.city=:cityCode order by show.updatedDttm")
	public List<ShowDTO> getShows(int movieId, String cityCode, LocalDate date);

}
