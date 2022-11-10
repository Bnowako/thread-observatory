import http from 'k6/http';
import { sleep } from 'k6';
import {defaultOptions} from "./options.js"

export const options = defaultOptions;

export default function () {
  http.get(`http://localhost:8081/sleep?sleepTimeMillis=${__ENV.SLEEP_TIME_MILLIS == null ? 1000 :__ENV.SLEEP_TIME_MILLIS}`);
  sleep(1);
}
