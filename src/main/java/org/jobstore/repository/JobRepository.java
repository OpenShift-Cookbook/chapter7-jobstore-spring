package org.jobstore.repository;

import java.util.List;

import org.jobstore.domain.Company;
import org.jobstore.domain.Job;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface JobRepository extends PagingAndSortingRepository<Job, Long> {

	@Query("SELECT NEW Job(j, c.id, c.name,c.description) FROM Job j JOIN j.company c WHERE j.company =:company")
	public List<Job> findAllByCompany(@Param("company") Company company);
	
	@Override
	@Query("SELECT NEW Job(j.id,j.title,j.description) FROM Job j WHERE j.id =:id")
	public Job findOne(@Param("id") Long id);
}
