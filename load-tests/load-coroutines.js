import http from 'k6/http';
import { sleep } from 'k6';
import {defaultOptions} from "./options.js"

export const options = defaultOptions;

export default function () {
  http.get('http://localhost:8080/coroutines/thread-sleep');
  sleep(1);
}
