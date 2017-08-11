/**************************************************************************
 **                                                                       *
 **                COPYRIGHT AND CONFIDENTIALITY NOTICE                   *
 **                                                                       *
 **    Copyright (c) 2011-2017 Holistic Labs Inc. All rights reserved.    *
 **                                                                       *
 **    This software contains information confidential and proprietary    *
 **    to Holistic Labs Inc.  It shall not be reproduced in whole or in   *
 **    part, or transferred to other documents, or disclosed to third     *
 **    parties, or used for any purpose other than that for which it was  *
 **    obtained, without the prior written consent of Holistic Labs Inc.  *
 **                                                                       *
 **************************************************************************/

/**
* @file hl_corr_dnsmasq.c
*
*	Implementation of the HL correlator module - dnsmasq log monitor
*
*/
#include <stdio.h>
#include <stddef.h>
#define FAIL 0
#define SUCCESS 1
#define MAX_LINE_LEN 512


/**
Read the file out and filter the date into dictionary of IP and domain. etc.
*/
size_t
dnsmasq()
{
    FILE* fp;
    char* line[MAX_LINE_LEN];
    ssize_t read;

    fp = fopen("./merged_dns_count.log", "r");

    if(fp == NULL)
    {
        printf("File is not exist");
        return FAIL;
    }

    printf("Start to read file\n");

    while(fgets(line, MAX_LINE_LEN, fp))
    {
        printf("%s", line);
    }

    fclose(fp);

    return 0;
}

void main(void){
    dnsmasq();
    return;
}
