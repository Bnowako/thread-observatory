export const defaultOptions = {
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