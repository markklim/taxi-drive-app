package systems.vostok.taxi.drive.app.dao.entity

import systems.vostok.taxi.drive.app.api.adapter.LocalDateTimeAdapter
import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter
import java.time.LocalDateTime

@Entity
@Table(name = 'rides')
@Canonical
@EqualsAndHashCode(includes = ['id'])
@ToString(includeNames = true, includeFields = true, excludes = 'id')
class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    String clientLogin
    Integer fromAddress
    Integer toAddress

    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    LocalDateTime dateIn

    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    LocalDateTime rideIn

    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    LocalDateTime rideOut

    String carId
    Integer adultInCar
    Integer childrenInCar
    String prepaid
    String comment
    Integer price
    String state
}
