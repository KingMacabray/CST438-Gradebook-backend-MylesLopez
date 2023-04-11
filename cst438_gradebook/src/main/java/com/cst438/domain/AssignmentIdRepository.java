package com.cst438.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AssignmentIdRepository extends CrudRepository <Assignment, Integer> {

	@Query("select a from Assignment a where a.id = assignmentId order by a.id")
	Assignment findAssignmentById(@Param("assignmentId") int assignmentId);
}
