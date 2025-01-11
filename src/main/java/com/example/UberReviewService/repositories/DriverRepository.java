package com.example.UberReviewService.repositories;

import com.example.UberReviewService.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
  Optional<Driver> findByIdAndLicenseNumber(Long id, String licenseNumber);

  // Rwa MySQL Query as error is thrown at runtime if any error is there, like column mismatched
  @Query(nativeQuery = true, value = "Select * from driver where id=:id and license_number =:license")
  Optional<Driver> rawFindByIdAndLicenseNumber(Long id,String license);

   // Hibernate Query HQL as error is thrown at compile time only.
   @Query("FROM Driver d WHERE d.id = :id AND d.licenseNumber = :license")
   Optional<Driver> hqlFindByIdAndLicenseNumber(@Param("id") Long id, @Param("license") String license);

   List<Driver> findAllByIdIn(List<Long> driverIds);

}
