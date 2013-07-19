//
//  ViewController.m
//  Primer
//
//  Created by Nick Walker on 7/16/13.
//  Copyright (c) 2013 Nick Walker. All rights reserved.
//

#import "ViewController.h"
#import <QuartzCore/QuartzCore.h>
#import "math.h"
#import "Prime.h"
@interface ViewController ()

@end

@implementation ViewController
bool testResult;
- (void)viewDidLoad
{
	UIView *paddingView = [[UIView alloc] initWithFrame:CGRectMake(0, 0, 40, 20)];
	self.inputField.leftView = paddingView;
	self.inputField.leftViewMode = UITextFieldViewModeAlways;
	UIView *paddingView2 = [[UIView alloc] initWithFrame:CGRectMake(0, 0, 40, 20)];
	self.inputField.rightView = paddingView2;
	self.inputField.rightViewMode = UITextFieldViewModeAlways;
    [super viewDidLoad];
	[self.inputField becomeFirstResponder];


	
}
- (IBAction)valueChanged:(UITextField*)inputField	{
	id primeTester = [[Prime alloc] init];
	[self.spinner startAnimating];
	dispatch_async(dispatch_get_global_queue(DISPATCH_QUEUE_PRIORITY_DEFAULT, 0), ^{

		testResult = [primeTester testPrimeness:(long long)[[inputField text] longLongValue]];
		dispatch_async(dispatch_get_main_queue(), ^{
			[self.spinner stopAnimating];
			if( testResult)
			{
				inputField.layer.backgroundColor = [[UIColor greenColor] CGColor];
			}
			else{
				inputField.layer.backgroundColor = [[UIColor redColor] CGColor];
			}
		});
	});
	
}
- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


@end