import http from 'k6/http';
import { sleep } from 'k6';


export const options = {
  scenarios: {
    constant_request_rate: {
      executor: 'constant-arrival-rate',
      rate: __ENV.RATE == null ? 10 : __ENV.RATE,
      timeUnit: '1s',
      duration: `${__ENV.DURATION == null ? 10 : __ENV.DURATION}s`,
      preAllocatedVUs: 100,
      maxVUs: 200,
    },
  },
};

export default function () {
  http.get(`http://localhost:8081/sleep?sleepTimeMillis=${__ENV.SLEEP_TIME_MILLIS == null ? 1000 :__ENV.SLEEP_TIME_MILLIS}`);
  sleep(1);
}
