/*
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * + Copyright 2024. NHN Academy Corp. All rights reserved.
 * + * While every precaution has been taken in the preparation of this resource,  assumes no
 * + responsibility for errors or omissions, or for damages resulting from the use of the information
 * + contained herein
 * + No part of this resource may be reproduced, stored in a retrieval system, or transmitted, in any
 * + form or by any means, electronic, mechanical, photocopying, recording, or otherwise, without the
 * + prior written permission.
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */

package thread;

import count.SharedCounter;
import java.util.*;
import java.util.stream.Collectors;

public class CounterIncreaseHandler implements Runnable {
    private final SharedCounter sharedCounter;

    private final List<String> threadHistory;

    public CounterIncreaseHandler(SharedCounter sharedCounter) {
        if (Objects.isNull(sharedCounter)) {
            throw new IllegalArgumentException(String.format("SharedCount is null"));
        }
        this.sharedCounter = sharedCounter;
        this.threadHistory = Collections.synchronizedList(new ArrayList<>());
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
                long count = sharedCounter.increaseAndGet();

                threadHistory.add(Thread.currentThread().getName());
                System.out.println("thread:" + Thread.currentThread().getName() + ", count:" + count);

                synchronized (this) {
                    while (true) {
                        System.out.println(Thread.currentThread().getName() + " is working!");
                    }
                }
            } catch (Exception e) {
                System.out.println(Thread.currentThread().getName() + " - interrupt!");
                Thread.currentThread().interrupt();
            }
        }
    }

    public Map<String, Long> getThreadHistory() {
        return threadHistory.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }
}
