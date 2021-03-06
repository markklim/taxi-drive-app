package systems.vostok.taxi.drive.app.dao.domain.query

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

class SearchParameters {
    @Size(min=1)
    List fields

    @NotBlank
    String request
}
