# CICD-1 Coding Test — Review, Improve and Reflect

**Student ID:**  G00429041

**Examination group:**  B (OpenFeign):  

**Original examination pull-request URL (`[cicd1-exam2_BookingService.zip](..%2F..%2F..%2F..%2FDownloads%2Fcicd1-exam2_BookingService.zip)`):**  

**New review repository URL:**  https://github.com/CarlosMDSN/CICD1_Review_G00429041

## 1. My original examination self-assessment

Review the code **as submitted in the original examination**. Do not change the original repository, branch or pull request. Check your own Group A or Group B examination paper and award marks only for evidence present in the original submission.

### Task 1 — /40
**My mark:**  5

**Evidence from the original code (files, methods, working or missing requirements):**  

file: src/main/java/ie/atu/sample/model/BookingModel.java

I created a BookingModel entity using @Entity annotation. I also implemented an ID field using @Id and @GeneratedValue(Strategy = GenerationType.IDENTITY)

I used Lombok annotations @Data and @NoArgsConstructor to generate getters, setters and a no argument constructor

However, I used a name field instead of the required organiserName field and a capacity field instead of attendeeCount

these were the requirements that were missing in my code:

Room ID

Booking status, initially ACTIVE

Request DTO

Response DTO

Validation to ensure the organiser name was not blank and contained between 2 and 60 characters

Validation to ensure attendee was a positive whole number

The reason for my mark is because i demonstrated a basic understanding of creating a JPA entity and primary key, but most of the required booking fields, DTOs and validation were not implemented
### Task 2 — /40
**My mark:**  2

**Evidence from the original code:**  

files:

src/main/java/ie/atu/sample/BookingServiceApplication.java

src/main/java/ie/atu/sample/service/Booking.java

src/main/java/ie/atu/sample/repository/BookingRepository.java

I included the @EnableFeignClients annotation in my main application class, showing an attempt to prepare the application for OpenFeign

I also created a repository extending JpaRepository<BookingModel, Long>

However, I did not implement an Openfeign client to retrieve room information from the Room service

I also did not implement the required POST / api/bookings endpoint

In my Booking.java class, I attempted to use CommandLineRunner to created booking objects when the application started and this was not the correct approach because bookings should be created when a client sends an HTTP POST request

These were the requirements that were missing from my code

Receiving booking information through a POST request

Retrieving room details using OpenFeign

Checking whether the room exists

Checking the room capacity against the attendee count

Rejecting bookings that exceed room capacity

saving a valid booking to the local H2 database

Returning an appropriate HTTP response

There was also an implementation problem in the constructor of the booking service because i used the Booking type instead of BookingRepository for the repository dependency

The reason for my mark is because i created a repository and included the Openfeign enable annotation but i did not implement the actual booking creation process or communication between the two microservices


### Task 3 — /20
**My mark:**  3

**Evidence from the original code:**  

file:  src/main/java/ie/atu/sample/controller/BookingController.java

I attempted to implement a GET endpoint using @GetMapping("/{id}") and @PathVariable

I also attempted to use findById() and ResponseStatusException with HttpStatus.NOT_FOUND to handle a booking that could not be found

However i made mistakes in the implementation

I used BookingRepository.findById(id) instead of calling thew injected repository instance bookingRepository.findById(id)

I also used int for the ID in the controller whereas the entity and repository used Long

Finally I returned the entity directly instead of using the required response DTO

The reason for my mark is because i believe i demonstrated an understanding of the intended GET endpoint and attempted to implement missing-booking handling, but the implementation contained errors and did not fully satisfy the requirements

**Total self-assessed original examination mark: 10/100**

**Checkpoint:** Commit this completed self-assessment as the **first review commit in your new repository**, before you modify or add application code. The lecturer decides the official original examination mark.

## 2. Corrections and improvements in my new project

Start from a **fresh copy of the starter template for your own exam group**, in a **new GitHub repository**. You may consult or selectively reuse your own original examination code, but the new project must demonstrate that you understand and can correct it. Do not change your original examination submission.

Describe **two or three important problems** in your original code. For each, explain what was wrong, which class or method you changed in the new project, and why the corrected approach works.

**Problem and correction 1:**  

**Problem and correction 2:**  

**Problem and correction 3 (optional):**  

## 3. API testing and evidence

Use Swagger UI or another HTTP client. For **at least four meaningful checks**, record the request/input, expected result, actual HTTP status/response, and pass/fail. Include unsuccessful cases; a running application alone is not enough.

**Test 1 — successful booking request:**  
- Request / input:  
- Expected:  
- Actual HTTP status / body:  
- Pass / fail:  

**Test 2 — invalid input or excessive attendee count:**  
- Request / input:  
- Expected:  
- Actual HTTP status / body:  
- Pass / fail:  

**Test 3 — missing booking or room:**  
- Request / input:  
- Expected:  
- Actual HTTP status / body:  
- Pass / fail:  

**Test 4 — requirement specific to my group:**  
- Request / input:  
- Expected:  
- Actual HTTP status / body:  
- Pass / fail:  

**Group A:** Demonstrate `GET /api/bookings/search?roomName=...` using an exact room name, bookings ordered by attendee count descending, and an empty list for no matches. Add checks if necessary to show all three behaviours.

**Group B:** Run the **provided** Room Service separately on port 8082 and the **new** Booking Service on port 8081. Demonstrate that booking creation obtains room details through OpenFeign and that booking retrieval uses the local Booking database. Do not modify the Room Service.

## 4. Reflection

**What did I understand during the examination but struggle to implement?**  

**Which Spring Boot, JPA, validation, JPQL or OpenFeign concept became clearer after correcting my code? Give a specific example.**  

**What will I do differently in my next coding test or API development task?**  

## Review lab assessment — 20 marks

- Honest original self-assessment with code evidence: **4 marks**
- Explanation of mistakes and Spring Boot concepts: **6 marks**
- Corrections in the new application: **4 marks**
- API testing and demonstration of understanding: **4 marks**
- Reflection and future improvement: **2 marks**

**Total: 20 marks.** Simply submitting a working solution does not demonstrate the learning required by this review.

## Proposed mark recovery — only if confirmed for CICD-1

If the same approach as OOP is adopted, the review could recover **up to 30% of marks lost** in the original examination, scaled by the review-lab mark.

**Marks recovered = (100 − official original exam mark) × 0.30 × (review lab mark ÷ 20)**

Example: exam **40/100** and review **16/20** → **14.4 recovered marks**, revised exam **54.4/100**. This is **not an approved CICD-1 policy unless confirmed by the lecturer**. The original official exam mark—not your self-awarded grade—is used in the calculation.

## Submission

Commit and push the **new review repository** with the completed README, corrected Spring Boot code and API-test evidence. Submit its GitHub URL on Moodle. **Do not push any changes to the original examination repository or `exam-work` pull request.**
