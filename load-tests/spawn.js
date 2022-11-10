import http from 'k6/http';
import { sleep } from 'k6';
import {defaultOptions} from "./options.js"

export const options = defaultOptions;

export default function () {
  http.get(`http://localhost:8081/objects/spawn?count=${__ENV.OBJECTS_COUNT == null ? 100 : __ENV.OBJECTS_COUNT}`);
  sleep(1);
}
