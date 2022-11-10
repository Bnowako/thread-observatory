import http from 'k6/http';
import { sleep } from 'k6';


export const options = {
  scenarios: {
    constant_request_rate: {
      executor: 'constant-arrival-rate',
      rate: 30,
      timeUnit: '1s',
      duration: '10s',
      preAllocatedVUs: 100,
      maxVUs: 200,
    },
  },
};

export default function () {
  http.get('http://localhost:8081/spawn/objects/spawn?count=1000');
  sleep(1);
}
