import http from 'k6/http';
import { sleep } from 'k6';
import {defaultOptions} from "./options";

export const options = defaultOptions;

export default function () {
  http.get('http://localhost:8081/blocking/sleep');
  sleep(1);
}
