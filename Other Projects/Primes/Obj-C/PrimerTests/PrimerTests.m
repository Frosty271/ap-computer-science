//
//  PrimerTests.m
//  PrimerTests
//
//  Created by Nick Walker on 7/16/13.
//  Copyright (c) 2013 Nick Walker. All rights reserved.
//

#import <XCTest/XCTest.h>
#import "Prime.h"
@interface PrimerTests : XCTestCase

@end

@implementation PrimerTests

- (void)setUp
{
    [super setUp];
    
    // Set-up code here.
}

- (void)tearDown
{
    // Tear-down code here.
    
    [super tearDown];
}

- (void)testAccuracy
{
	id test = [[Prime alloc] init];
	XCTAssertTrue( [test testPrimeness:6]);
	XCTAssertTrue( [test testPrimeness:1021]);
	XCTAssertTrue( [test testPrimeness:2147483647]);
}
@end
