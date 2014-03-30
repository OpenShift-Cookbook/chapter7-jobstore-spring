package org.jobstore.repository;

import java.util.List;

import org.jobstore.domain.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {
	
	@Override
	@Query("SELECT NEW Company(c.id,c.name,c.description) FROM Company c")
	public List<Company> findAll();
	
	@Query("SELECT NEW Company(c.id,c.name,c.description) FROM Company c WHERE c.name =:name")
	public Company findByName(@Param("name") String name);
	
	@Override
	@Query("SELECT NEW Company(c.id,c.name,c.description) FROM Company c WHERE c.id =:id")
	public Company findOne(@Param("id") Long id);
}
