echo 'creating initial data'

echo 'creating interviewers'

curl -X 'POST' \
  'http://localhost:8070/person' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "name": "Interviewer1",
  "role": "INTERVIEWER"
}'

curl -X 'POST' \
  'http://localhost:8070/person' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "name": "Interviewer2",
  "role": "INTERVIEWER"
}'

curl -X 'POST' \
  'http://localhost:8070/person' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "name": "Interviewer3",
  "role": "INTERVIEWER"
}'

echo 'creating candidates'

curl -X 'POST' \
  'http://localhost:8070/person' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "name": "Candidate1",
  "role": "CANDIDATE"
}'

curl -X 'POST' \
  'http://localhost:8070/person' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "name": "Candidate2",
  "role": "CANDIDATE"
}'

curl -X 'POST' \
  'http://localhost:8070/person' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "name": "Candidate3",
  "role": "CANDIDATE"
}'

echo 'creating interviewers slots'

curl -X 'POST' \
  'http://localhost:8070/slot' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "personName": "Interviewer1",
  "start": 8,
  "end": 12,
  "daysOfWeek": [
    "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"
  ]
}'

curl -X 'POST' \
  'http://localhost:8070/slot' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "personName": "Interviewer2",
  "start": 13,
  "end": 18,
  "daysOfWeek": [
    "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"
  ]
}'

curl -X 'POST' \
  'http://localhost:8070/slot' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "personName": "Interviewer3",
  "start": 10,
  "end": 16,
  "daysOfWeek": [
    "MONDAY", "WEDNESDAY", "FRIDAY"
  ]
}'

echo 'creating candidates slots'

curl -X 'POST' \
  'http://localhost:8070/slot' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "personName": "Candidate1",
  "start": 9,
  "end": 19,
  "daysOfWeek": [
    "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"
  ]
}'

curl -X 'POST' \
  'http://localhost:8070/slot' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "personName": "Candidate2",
  "start": 8,
  "end": 12,
  "daysOfWeek": [
    "TUESDAY", "THURSDAY"
  ]
}'

curl -X 'POST' \
  'http://localhost:8070/slot' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "personName": "Candidate3",
  "start": 8,
  "end": 18,
  "daysOfWeek": [
    "MONDAY", "FRIDAY"
  ]
}'

echo 'done!'