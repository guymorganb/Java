import React, { useRef, useEffect } from 'react';
import gsap from 'gsap';
import {Box} from "@chakra-ui/react";

export const ArrowSvg = () => {
    const arrowRef = useRef(null);

    useEffect(() => {
        const path = arrowRef.current;
        const pathLength = path.getTotalLength();

        gsap.set(path, {
            strokeDasharray: pathLength,
            strokeDashoffset: pathLength,
            opacity: 1
        });

        gsap.to(path, {
            strokeDashoffset: 0,
            duration: 3,
            ease: "power1.inOut",
            delay: 3
        });
    }, []);

    return(
        <>
         <Box as='svg' position="absolute" top="0" left="0" width="100%" height="100%" viewBox="80 -280 870 1250" >
                <path ref={arrowRef}  d="M-70 220.32052612304688Q872.4819641113281 -220.67947387695312 304.9819641113281 432.8205261230469Q-118.51803588867188 948.3205261230469 514.4819641113281 642.3205261230469 " markerEnd="url(#SvgjsMarker7276)" markerStart="url(#SvgjsMarker7277)" stroke="hsl(205, 69%, 50%)" strokeLinecap="round" strokeLinejoin="round" transform="matrix(1,0,0,1,-23,7)"fill="none" fillRule="nonzero" style={{ opacity: 0, animation: 'fadeIn 3.5s forwards' }}/>
                <defs>
                    <marker markerWidth="10" markerHeight="10" refX="5" refY="5" viewBox="0 0 10 10" orient="auto"      id="SvgjsMarker7276">
                        <polyline points="0,5 5,2.5 0,0" fill="none" strokeWidth="1.6666666666666667" stroke="hsl(205, 69%, 50%)" strokeLinecap="round" transform="matrix(1,0,0,1,1.6666666666666667,2.5)" strokeLinejoin="round">
                        </polyline>
                    </marker>
                    <marker markerWidth="10" markerHeight="10" refX="5" refY="5" viewBox="0 0 10 10" orient="auto" id="SvgjsMarker7277">
                        <polyline points="5,5 0,2.5 5,0" fill="none" strokeWidth="1.6666666666666667" stroke="hsl(205, 69%, 50%)" strokeLinecap="round" transform="matrix(1,0,0,1,3.3333333333333335,2.5)" strokeLinejoin="round">
                        </polyline>
                    </marker>
                </defs>
            </Box>
        </>
    )

}

