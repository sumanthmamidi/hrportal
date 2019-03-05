/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.0-SNAPSHOT).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.mp.hr.api;

import com.mp.hr.model.Candidate;
import com.mp.hr.model.ErrorResponse;
import com.mp.hr.model.SuccessResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Api(value = "candidates", description = "the candidates API")
public interface CandidatesApi {

    Logger log = LoggerFactory.getLogger(CandidatesApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "Adds new Candidate", nickname = "addCandidate", notes = "Add a new dashBoard to the collection.", response = SuccessResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Candidate created successfully", response = SuccessResponse.class) })
    @RequestMapping(value = "/candidates",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    default ResponseEntity<SuccessResponse> addCandidate(@ApiParam(value = "Candidate JSON Object"  )  @Valid @RequestBody Candidate candidate) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"id\" : \"id\"}", SuccessResponse.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default CandidatesApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Delete the Candidate", nickname = "deleteCandidate", notes = "Deletes Candidate", response = SuccessResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Deletion successful", response = SuccessResponse.class),
        @ApiResponse(code = 404, message = "Candidate does not exists.", response = ErrorResponse.class),
        @ApiResponse(code = 500, message = "Error occured during the Dashboard deletion.", response = ErrorResponse.class) })
    @RequestMapping(value = "/candidates/{candidateId}",
        method = RequestMethod.DELETE)
    default ResponseEntity<SuccessResponse> deleteCandidate(@ApiParam(value = "Candidate's Id.",required=true) @PathVariable("candidateId") String candidateId) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"id\" : \"id\"}", SuccessResponse.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default CandidatesApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Get Candidate by Id", nickname = "getCandidate", notes = "Returns a Candidate", response = Candidate.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A Candidate", response = Candidate.class),
        @ApiResponse(code = 404, message = "The Candidate does not exists.", response = ErrorResponse.class) })
    @RequestMapping(value = "/candidates/{candidateId}",
        method = RequestMethod.GET)
    default ResponseEntity<Candidate> getCandidate(@ApiParam(value = "Candidate's Id.",required=true) @PathVariable("candidateId") String candidateId) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"noticePeriod\" : \"noticePeriod\",  \"passoutYear\" : 6,  \"resumeId\" : \"resumeId\",  \"name\" : \"name\",  \"source\" : \"source\",  \"experience\" : 0,  \"phoneNo\" : \"phoneNo\",  \"email\" : \"email\"}", Candidate.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default CandidatesApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "get all Candidate details", nickname = "getCandidates", notes = "get all Candidates", response = Candidate.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Returns all Dashboard details. Response object will be list of Dashboard. Please refer DashboardMetadata model structure.", response = Candidate.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad request. Response object contains error message.", response = ErrorResponse.class),
        @ApiResponse(code = 500, message = "Error in fetching the Dashboards. Response object contains error message.", response = ErrorResponse.class) })
    @RequestMapping(value = "/candidates",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<Candidate>> getCandidates(@NotNull @ApiParam(value = "Candidate selected.", required = true) @Valid @RequestParam(value = "candidateId", required = true) String candidateId) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {  \"noticePeriod\" : \"noticePeriod\",  \"passoutYear\" : 6,  \"resumeId\" : \"resumeId\",  \"name\" : \"name\",  \"source\" : \"source\",  \"experience\" : 0,  \"phoneNo\" : \"phoneNo\",  \"email\" : \"email\"}, {  \"noticePeriod\" : \"noticePeriod\",  \"passoutYear\" : 6,  \"resumeId\" : \"resumeId\",  \"name\" : \"name\",  \"source\" : \"source\",  \"experience\" : 0,  \"phoneNo\" : \"phoneNo\",  \"email\" : \"email\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default CandidatesApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Updates the exisiting candidate", nickname = "updateCandidate", notes = "Updates the exisiting candidate.", response = SuccessResponse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Candidate created successfully", response = SuccessResponse.class) })
    @RequestMapping(value = "/candidates",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    default ResponseEntity<SuccessResponse> updateCandidate(@ApiParam(value = "Candidate JSON Object"  )  @Valid @RequestBody Candidate candidate) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"id\" : \"id\"}", SuccessResponse.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default CandidatesApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}