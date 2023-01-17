import http from 'k6/http';
import {sleep} from 'k6';

import {defaultOptions} from "../options.js";
import {payload} from "./payload.js";

export const options = defaultOptions;

export default function () {
    const mode = __ENV.MODE

    let uri = ''
    if (mode === "REGEX") {

    } else if (mode === "PRECOMPILED_REGEX") {
        uri += "/precompiled"
    } else if (mode === "JAVA_API") {
        uri += "/precompiled/java-api"
    }

    http.post(`http://localhost:8081/check${uri}`, JSON.stringify(payload),{ headers: { 'Content-Type': 'application/json' }});
    sleep(1);
}
