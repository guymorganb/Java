import React, { useRef, useEffect } from 'react';
import gsap from 'gsap';
import {Box, VStack, HStack, Flex, Image} from "@chakra-ui/react";
import {Bg} from "../assets/util/backgrounds/bg.jsx";
import { Nav } from "../components/landingPage/nav.jsx";
import { LeftSide } from "../components/landingPage/leftSide.jsx";
import { RightSide } from "../components/landingPage/rightSide.jsx";
import { ArrowSvg } from '../assets/custom_css_svgs/arrow_svg.jsx';
import { Footer } from '../components/landingPage/footer.jsx';
import {Bg2} from "../assets/util/backgrounds/bg2.jsx";

export const LandingPage = () => {
  
    const bgStyle = {
        backgroundImage: `url("data:image/svg+xml;utf8,${encodeURIComponent(Bg2)}")`,
        zIndex: -2 // Background
    }

    return(
        <>
             <Box>
                    {/* <ArrowSvg/> */}
                </Box>
            <Box className="leading-normal tracking-normal text-gray-900" fontFamily="'Source Sans Pro', sans-serif">
                <Box className="h-screen pb-14 bg-right bg-cover" style={bgStyle}>
                    <Box>
                        <Nav/>
                    </Box>
                    <Box>
                        {/* <LeftSide/> */}
                    </Box>
                    <Box>
                        {/* <RightSide/>  */}
                    </Box>
                    <Box>
                        <Footer/> 
                    </Box>
                </Box>
            </Box>
        </>
    )

}

